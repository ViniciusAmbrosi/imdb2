package com.sap.acme.imdb2.repository.interfaces;

import java.util.List;
import com.sap.acme.imdb2.entity.Genre;

public interface GenreDao {

	List<Genre> findGenres();
}
