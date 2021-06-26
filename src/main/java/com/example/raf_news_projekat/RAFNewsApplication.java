package com.example.raf_news_projekat;

import com.example.raf_news_projekat.repository.IKategorijaRepository;
import com.example.raf_news_projekat.repository.IKorisnikRepository;
import com.example.raf_news_projekat.repository.IVestRepository;
import com.example.raf_news_projekat.repository.implementations.MySqlKategorijaRepository;
import com.example.raf_news_projekat.repository.implementations.MySqlKorisnikRepository;
import com.example.raf_news_projekat.repository.implementations.MySqlVestRepository;
import com.example.raf_news_projekat.services.KategorijaService;
import com.example.raf_news_projekat.services.KorisnikService;
import com.example.raf_news_projekat.services.VestService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RAFNewsApplication extends ResourceConfig {

    public RAFNewsApplication() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(MySqlKategorijaRepository.class).to(IKategorijaRepository.class).in(Singleton.class);
                this.bind(MySqlKorisnikRepository.class).to(IKorisnikRepository.class).in(Singleton.class);
                this.bind(MySqlVestRepository.class).to(IVestRepository.class).in(Singleton.class);
                this.bindAsContract(KategorijaService.class);
                this.bindAsContract(KorisnikService.class);
                this.bindAsContract(VestService.class);
            }
        };
        register(binder);

        packages("com.example.raf_news_projekat");
    }

}