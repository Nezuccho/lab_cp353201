//นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

package sqa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import sqa.data.stub.MovieServiceStub;
import sqa.lab.api.MovieService;
import sqa.lab.service.FavouriteMovie;

class FavouriteMovieTest {

	@Test
	void test_getActionMovieWithStub() {
		MovieService movieService = new MovieServiceStub();
		FavouriteMovie favouriteMovie = new FavouriteMovie(movieService);
		
		List<String> movieList = favouriteMovie.getMovie("Nezuccho", "action");
		
		assertEquals(5, movieList.size());		
	}

}
