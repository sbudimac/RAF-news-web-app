package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.Korisnik;
import com.example.raf_news_projekat.model.Status;
import com.example.raf_news_projekat.model.TipKorisnika;
import com.example.raf_news_projekat.repository.IKorisnikRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlKorisnikRepository extends MySqlAbstractRepository implements IKorisnikRepository {

    @Override
    public List<Korisnik> getKorisnici() {
        List<Korisnik> korisnici = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM korisnik");

            while (resultSet.next()) {
                korisnici.add(new Korisnik(resultSet.getInt("korisnik_id"),
                                           resultSet.getString("email"),
                                           resultSet.getString("ime"),
                                           resultSet.getString("prezime"),
                                           TipKorisnika.valueOf(resultSet.getString("tip")),
                                           Status.valueOf(resultSet.getString("status")),
                                           resultSet.getString("lozinka")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return korisnici;
    }

    @Override
    public Korisnik dodajKorisnika(Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO korisnik (email, ime, prezime, lozinka, tip, status) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            setKorisnik(korisnik, preparedStatement);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                korisnik.setKorisnikId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return korisnik;
    }

    @Override
    public Korisnik izmeniKorisnika(Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE korisnik SET email = ?, ime = ?, prezime = ?, lozinka = ?, tip = ?, status = ? WHERE korisnik_id = ?"
            );
            setKorisnik(korisnik, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return korisnik;
    }

    private void setKorisnik(Korisnik korisnik, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, korisnik.getEmail());
        preparedStatement.setString(2, korisnik.getIme());
        preparedStatement.setString(3, korisnik.getPrezime());
        preparedStatement.setString(4, korisnik.getLozinka());
        preparedStatement.setString(5, korisnik.getTip().toString());
        preparedStatement.setString(6, korisnik.getStatus().toString());
    }
}
