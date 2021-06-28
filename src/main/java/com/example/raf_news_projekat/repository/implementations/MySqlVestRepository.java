package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.*;
import com.example.raf_news_projekat.repository.IVestRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlVestRepository extends MySqlAbstractRepository implements IVestRepository {
    private static final int BR_HOME_PAGE_VESTI = 10;
    private static final int BR_NAJCITANIJIH_VESTI = 10;

    @Override
    public List<Vest> getVesti() {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vest ORDER BY vreme_kreiranja DESC");
            resultSet = preparedStatement.executeQuery();

            traverseVesti(vesti, connection, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    @Override
    public Vest findVest(Integer id) {
        Vest vest = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vest WHERE vest_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String naslov = resultSet.getString("naslov");
                String tekst = resultSet.getString("tekst");
                Date vremeKreiranja = resultSet.getDate("vreme_kreiranja");
                Integer brojPoseta = resultSet.getInt("broj_poseta");
                Integer autorId = resultSet.getInt("autor_id");
                Integer kategorijaId = resultSet.getInt("kategorija_id");
                vest = new Vest(naslov, tekst, vremeKreiranja, brojPoseta, autorId, kategorijaId);
                vest.setVremeKreiranja(vremeKreiranja);

                //completeVest(connection, preparedStatement, vest, idAutora, idKategorije);
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
    public Vest dodajVest(Vest vest) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO vest (naslov, tekst, vreme_kreiranja, broj_poseta, autor_id, kategorija_id) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, vest.getNaslov());
            preparedStatement.setString(2, vest.getTekst());
            preparedStatement.setDate(3, vest.getVremeKreiranja());
            preparedStatement.setInt(4, vest.getBrojPoseta());
            preparedStatement.setInt(5, vest.getAutorId());
            preparedStatement.setInt(6, vest.getKategorijaId());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                vest.setVestId(resultSet.getInt(1));
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

    /*
        dodavanje tagova
     */
    @Override
    public Vest izmeniVest(Vest vest) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE vest SET naslov = ?, tekst = ?, vreme_kreiranja = ?, broj_poseta = ?, kategorija_id = ?"
            );
            preparedStatement.setString(1, vest.getNaslov());
            preparedStatement.setString(2, vest.getTekst());
            preparedStatement.setDate(3, vest.getVremeKreiranja());
            preparedStatement.setInt(4, vest.getBrojPoseta());
            preparedStatement.setInt(5, vest.getKategorijaId());
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
    public void obrisiVest(Integer vestId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM vest WHERE vest_id = ?");
            preparedStatement.setInt(1, vestId);
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vest ORDER BY vreme_kreiranja DESC LIMIT ?");
            preparedStatement.setInt(1, BR_HOME_PAGE_VESTI);
            resultSet = preparedStatement.executeQuery();

            traverseVesti(vesti, connection, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    @Override
    public List<Vest> getNajcitanijeVesti() {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vest WHERE DATE(vreme_kreiranja) >= DATE(NOW()) - INTERVAL 1 DAY ORDER BY broj_poseta DESC LIMIT ?"
            );
            preparedStatement.setInt(1, BR_NAJCITANIJIH_VESTI);
            resultSet = preparedStatement.executeQuery();

            traverseVesti(vesti, connection, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    @Override
    public List<Vest> getKategorijaVesti(Integer kategorijaId) {
        List<Vest> vesti = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM vest INNER JOIN kategorija ON vest.kategorija_id = kategorija.kategorija_id WHERE kategorija.kategorija_id = ?"
            );
            preparedStatement.setInt(1, kategorijaId);
            resultSet = preparedStatement.executeQuery();

            traverseVesti(vesti, connection, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return vesti;
    }

    private void traverseVesti(List<Vest> vesti, Connection connection, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Vest vest = null;

            vest = new Vest(resultSet.getInt("vest_id"),
                            resultSet.getString("naslov"),
                            resultSet.getString("tekst"),
                            resultSet.getInt("broj_poseta"));
            vest.setVremeKreiranja(resultSet.getDate("vreme_kreiranja"));
            vest.setAutorId(resultSet.getInt("autor_id"));
            vest.setKategorijaId(resultSet.getInt("kategorija_id"));

            //completeVest(connection, null, vest, idAutora, idKategorije);

            vesti.add(vest);
        }
    }

    /*private void completeVest(Connection connection, PreparedStatement preparedStatement, Integer vestId, Integer autorId, Integer kategorijaId) {
        ResultSet subResultSet = null;

        try{
            Korisnik autor = null;
            Kategorija kategorija = null;
            List<Tag> tagovi = new ArrayList<>();

            preparedStatement = connection.prepareStatement("SELECT * FROM korisnik WHERE korisnik_id = ?");
            preparedStatement.setInt(1, idAutora);
            subResultSet = preparedStatement.executeQuery();
            if (subResultSet.next()) {
                Integer korisnikId = subResultSet.getInt("korisnik_id");
                String email = subResultSet.getString("email");
                String ime = subResultSet.getString("ime");
                String prezime = subResultSet.getString("prezime");
                String lozinka = subResultSet.getString("lozinka");
                TipKorisnika tip = TipKorisnika.valueOf(subResultSet.getString("tip"));
                Status status = Status.valueOf(subResultSet.getString("status"));
                autor = new Korisnik(korisnikId, email, ime, prezime, tip, status, lozinka);
            }

            preparedStatement = connection.prepareStatement("SELECT * FROM kategorija WHERE kategorija_id = ?");
            preparedStatement.setInt(1, idKategorije);
            subResultSet = preparedStatement.executeQuery();
            if (subResultSet.next()) {
                Integer kategorijaId = subResultSet.getInt("kategorija_id");
                String ime = subResultSet.getString("ime");
                String opis = subResultSet.getString("opis");
                kategorija = new Kategorija(kategorijaId, ime, opis);
            }

            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tag JOIN vesti_tagovi ON tag.tag_id = vesti_tagovi.tag_id JOIN vest ON vesti_tagovi.vest_id WHERE vesti_tagovi.vest_id = ?"
            );
            preparedStatement.setInt(1, vest.getVestId());
            subResultSet = preparedStatement.executeQuery();
            while (subResultSet.next()) {
                tagovi.add(new Tag(subResultSet.getInt("tag_id"), subResultSet.getString("reci")));
            }

            assert autor != null;
            vest.setAutor(autor);
            assert kategorija != null;
            vest.setKategorija(kategorija);
            vest.setTagovi(tagovi);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(subResultSet);
        }
    }*/
}
