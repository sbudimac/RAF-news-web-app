package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.repository.IKategorijaRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlKategorijaRepository extends MySqlAbstractRepository implements IKategorijaRepository {
    @Override
    public List<Kategorija> getKategorije() {
        List<Kategorija> kategorije = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kategorija");

            while (resultSet.next()) {
                kategorije.add(new Kategorija(resultSet.getInt("kategorija_id"), resultSet.getString("ime"), resultSet.getString("opis")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return kategorije;
    }
}
