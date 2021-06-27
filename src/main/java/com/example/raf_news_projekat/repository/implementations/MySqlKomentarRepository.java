package com.example.raf_news_projekat.repository.implementations;

import com.example.raf_news_projekat.model.Komentar;
import com.example.raf_news_projekat.repository.IKomentarRepository;
import com.example.raf_news_projekat.repository.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlKomentarRepository extends MySqlAbstractRepository implements IKomentarRepository {
    @Override
    public List<Komentar> getVestKomentari(Integer vestId) {
        List<Komentar> komentari = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM komentar WHERE vest_id = ? ORDER BY datum_kreiranja DESC");
            preparedStatement.setInt(1, vestId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Komentar komentar = null;

                komentar = new Komentar(resultSet.getString("ime_autora"),
                                        resultSet.getString("tekst"),
                                        resultSet.getDate("datum_kreiranja"));
                komentari.add(komentar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }

        return komentari;
    }

    @Override
    public Komentar dodajKomentar(Komentar komentar, Integer vestId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO komentar (ime_autora, tekst, datum_kreiranja) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, komentar.getImeAutora());
            preparedStatement.setString(2, komentar.getKomentar());
            preparedStatement.setDate(3, komentar.getDatumKreiranja());
            preparedStatement.setInt(4, vestId);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                komentar.setKomentarId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return komentar;
    }
}
