package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.Kategorija;
import com.example.raf_news_projekat.model.Vest;
import com.example.raf_news_projekat.repository.IVestRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlVestRepository extends MySqlAbstractRepository implements IVestRepository {
    private static final int BR_HOME_PAGE_VESTI = 10;
    private static final int BR_NAJCITANIJIH_VESTI = 10;

    @Override
    public Vest dodajVest(Vest vest) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            String[] generatedColumns = {"vest_id"};
            preparedStatement = connection.prepareStatement("INSERT INTO vest (naslov, tekst, vreme_kreiranja, broj_poseta) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, vest.getNaslov());
            preparedStatement.setString(2, vest.getTekst());
            preparedStatement.setDate(3, (Date) vest.getVremeKreiranja());
            preparedStatement.setInt(4, vest.getBrojPoseta());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                vest.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vest;
    }

    @Override
    public Vest izmeniVest(Vest vest) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("UPDATE vest SET naslov = ?, tekst = ?, vreme_kreiranja = ?, broj_poseta = ?");
            preparedStatement.setString(1, vest.getNaslov());
            preparedStatement.setString(2, vest.getTekst());
            preparedStatement.setDate(3, (Date) vest.getVremeKreiranja());
            preparedStatement.setInt(4, vest.getBrojPoseta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return vest;
    }

    @Override
    public void obrisiVest(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM vest WHERE vest_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection(connection);
            this.closeStatement(preparedStatement);
        }
    }

    @Override
    public List<Vest> getHomePageVesti() {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM vest ORDER BY vreme_kreiranja DESC FETCH FIRST " + BR_HOME_PAGE_VESTI);

            while (resultSet.next()) {
                vesti.add(new Vest(resultSet.getInt("vest_id"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vreme_kreiranja"), resultSet.getInt("broj_poseta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    @Override
    public List<Vest> getNajcitanijeVesti() {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM vest ORDER BY broj_poseta DESC FETCH FIRST " + BR_NAJCITANIJIH_VESTI);

            while (resultSet.next()) {
                vesti.add(new Vest(resultSet.getInt("vest_id"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vreme_kreiranja"), resultSet.getInt("broj_poseta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    @Override
    public List<Vest> getKategorijaVesti(Kategorija kategorija) {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM vest INNER JOIN kategorija ON vest_kategorija_kategorija_id_fk = kategorija.kategorija_id");

            while (resultSet.next()) {
                vesti.add(new Vest(resultSet.getInt("vest_id"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vreme_kreiranja"), resultSet.getInt("broj_poseta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }
}
