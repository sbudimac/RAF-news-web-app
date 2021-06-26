package com.example.raf_news_projekat.filters;

import com.example.raf_news_projekat.resources.cms.CMSKategorijaResource;
import com.example.raf_news_projekat.resources.cms.CMSKorisnikResource;
import com.example.raf_news_projekat.resources.cms.CMSVestResource;
import com.example.raf_news_projekat.services.KorisnikService;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Inject
    private KorisnikService korisnikService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (!this.isAuthRequired(requestContext)) {
            return;
        }

        try {
            String token = requestContext.getHeaderString("Authorization");
            if(token != null && token.startsWith("Bearer ")) {
                token = token.replace("Bearer ", "");
            }

            if (!this.korisnikService.isAuthorized(token)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private boolean isAuthRequired(ContainerRequestContext req) {
        if (req.getUriInfo().getPath().contains("login")) {
            return false;
        }

        List<Object> matchedResources = req.getUriInfo().getMatchedResources();
        for (Object matchedResource : matchedResources) {
            if (matchedResource instanceof CMSKategorijaResource || matchedResource instanceof CMSKorisnikResource || matchedResource instanceof CMSVestResource) {
                return true;
            }
        }

        return false;
    }
}
