package at.ac.fhcampuswien.fhmdb;

import java.sql.SQLException;

public interface ClickEventHandler  <T> {
   void onClick(T t);
}
