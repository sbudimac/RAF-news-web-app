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
    public Korisnik getKorisnik(Integer id) {
        Korisnik korisnik = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM korisnik WHERE korisnik_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer korisnikId = resultSet.getInt("korisnik_id");
                String email = resultSet.getString("email");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                String lozinka = resultSet.getString("lozinka");
                String tip = resultSet.getString("tip");
                String status = resultSet.getString("status");

                korisnik = new Korisnik(korisnikId, email, ime, prezime, TipKorisnika.valueOf(tip), Status.valueOf(status), lozinka);
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
    public Korisnik findKorisnik(String korisnikEmail) {
        Korisnik korisnik = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM korisnik WHERE email LIKE ?");
            preparedStatement.setString(1, korisnikEmail);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer korisnikId = resultSet.getInt("korisnik_id");
                String email = resultSet.getString("email");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                String lozinka = resultSet.getString("lozinka");
                String tip = resultSet.getString("tip");
                String status = resultSet.getString("status");

                korisnik = new Korisnik(korisnikId, email, ime, prezime, TipKorisnika.valueOf(tip), Status.valueOf(status), lozinka);
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
    public Korisnik dodajKorisnika(Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO korisnik (email, ime, prezime, lozinka, tip, status) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
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
    public Korisnik izmeniKorisnika(Integer id, Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE korisnik SET email = ?, ime = ?, prezime = ?, lozinka = ?, tip = ?, status = ? WHERE korisnik_id = ?"
            );
            setKorisnik(korisnik, preparedStatement);
            korisnik.setKorisnikId(id);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return korisnik;
    }

    @Override
    public Korisnik aktivirajKorisnika(Integer id, Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("UPDATE korisnik SET status = ? WHERE korisnik_id = ?");
            preparedStatement.setString(1, Status.AKTIVAN.toString());
            preparedStatement.setInt(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return korisnik;
    }

    @Override
    public Korisnik deaktivirajKorisnika(Integer id, Korisnik korisnik) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("UPDATE korisnik SET status = ? WHERE korisnik_id = ?");
            preparedStatement.setString(1, Status.NEAKTIVAN.toString());
            preparedStatement.setInt(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }

        return korisnik;
    }

    @Override
    public void obrisiKorisnika(Integer korisnikId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM korisnik WHERE korisnik_id = ?");
            preparedStatement.setInt(1, korisnikId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection(connection);
            this.closeStatement(preparedStatement);
        }
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
