package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.repository.IKategorijaRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.*;
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
                kategorije.add(new Kategorija(resultSet.getInt("kategorija_id"),
                                              resultSet.getString("ime"),
                                              resultSet.getString("opis")));
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

    @Override
    public Kategorija dodajKategoriju(Kategorija kategorija) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO kategorija VALUES (?, ?)");
            preparedStatement.setString(1, kategorija.getIme());
            preparedStatement.setString(2, kategorija.getOpis());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                kategorija.setKategorijaId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return kategorija;
    }

    @Override
    public Kategorija izmeniKategoriju(Kategorija kategorija) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE kategorija SET ime = ?, opis = ? WHERE kategorija_id = ?"
            );
            preparedStatement.setString(1, kategorija.getIme());
            preparedStatement.setString(2, kategorija.getOpis());
            preparedStatement.setInt(3, kategorija.getKategorijaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return kategorija;
    }

    @Override
    public void obrisiKategoriju(Integer kategorijaId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM kategorija WHERE kategorija_id = ?");
            preparedStatement.setInt(1, kategorijaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }
    }
}
