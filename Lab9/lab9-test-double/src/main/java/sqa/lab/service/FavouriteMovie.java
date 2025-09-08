//นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

package sqa.lab.service;

import java.util.ArrayList;
import java.util.List;

import sqa.lab.api.MovieService;

public class FavouriteMovie {
	
	private MovieService movieService;
	
	public FavouriteMovie(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	
	public List<String> getMovie(String username, String playlistName) {
		List<String> movieList = new ArrayList<String>();
		List<String> allMovieList = movieService.getMovieList(username);
			
		for (String movie: allMovieList) {
			if (movie.contains(playlistName)) {
				movieList.add(movie);
			}
		}
		return movieList;
	}
}
