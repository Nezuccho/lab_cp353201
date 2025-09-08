//นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

package sqa.data.stub;

import java.util.Arrays;
import java.util.List;

import sqa.lab.api.MovieService;

public class MovieServiceStub implements MovieService{

	public List<String> getMovieList(String username) {
		return Arrays.asList(
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
	}
	
}
