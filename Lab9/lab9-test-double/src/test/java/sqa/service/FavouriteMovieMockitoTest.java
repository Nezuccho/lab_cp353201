//นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

package sqa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import sqa.lab.api.MovieService;
import sqa.lab.service.FavouriteMovie;

class FavouriteMovieMockitoTest {

	@Test
	void testUsingMockito() {
		MovieService movieService = mock(MovieService.class);
		List<String> movieList = Arrays.asList(
				"[datenight] The Notebook",
				"[datenight] 50 First Dates",
				"[datenight] A Walk to Remember",
				"[datenight] First Love", 
				"[datenight] The Lucky One",
				"[horror] The Conjuring: The Devil Made Me Do It",
				"[horror] The Nun",
				"[horror] Sinners",
				"[action] Jurassic World: Rebirth",
				"[action] The Fantastic Four: First Steps",
				"[action] Demon Slayer: Kimetsu no Yaiba Infinity Castle",
				"[action] A Minecraft Movie",
				"[action] 47. Dune: Part Two"
			);
		
		when(movieService.getMovieList("Nezuccho")).thenReturn(movieList);
		
		FavouriteMovie favouriteMovie = new FavouriteMovie(movieService);
		List<String> favouriteMovieList = favouriteMovie.getMovie("Nezuccho", "action");
		
		assertEquals(5, favouriteMovieList.size());		
	}

}
