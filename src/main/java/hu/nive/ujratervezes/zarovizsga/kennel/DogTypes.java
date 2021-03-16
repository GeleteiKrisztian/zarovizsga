package hu.nive.ujratervezes.zarovizsga.kennel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource ds;

    public DogTypes(DataSource ds) {
        this.ds = ds;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogNames = new ArrayList<>();
        try(Connection conn = ds.getConnection();
            PreparedStatement pStmt = conn.prepareStatement("SELECT name FROM dog_types WHERE country = ?")) {
            pStmt.setString(1, country);
            ResultSet res = pStmt.executeQuery();
            while (res.next()) {
                dogNames.add(res.getString("name").toLowerCase());
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Database error.", sqlException);
        }
        return dogNames;
    }
}
