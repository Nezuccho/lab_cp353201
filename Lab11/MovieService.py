from flask import Flask, request
from flask_restful import Resource, Api
from flasgger import Swagger

app = Flask(__name__)
api = Api(app)
swagger = Swagger(app)

movies = [{
        "playlist_id": 0,
        "playlist_name": "datenight",
        "movie_list": ["The Notebook", "50 First Dates", "A Walk to Remember"]
    },
    {
        "playlist_id": 1,
        "playlist_name": "action",
        "movie_list": ["Die Hard", "Mad Max: Fury Road", "John Wick"]
    },

    {
        "playlist_id": 2,
        "playlist_name": "comedy",
        "movie_list": ["Superbad", "Step Brothers", "The Hangover"]
    }
]


class MovieService(Resource):
    def get(self):
        """ 
        Get a list of all playlists
        ---
        responses:
          200:
            description: A list of playlists
        """
        return movies, 200

    def post(self):
        """
        Create a new playlist
        ---
        parameters:
          - in: body
            name: playlist
            required: true
            schema: 
                id: playlist 
                required:
                    - playlist_name 
                properties: 
                    playlist_name: 
                        type: string 
                        description: The name of the playlist
                    movie_list:
                        type: array
                        items:
                            type: string
                        description: List of movie in the playlist
        responses:
            201:
                description: A new playlist created
            400:
                description: Bad request
        """
        new_id = movies[-1]['playlist_id'] + 1
        data = request.get_json()       # retrieves the JSON data from the request object
        new_playlist = {'playlist_id': new_id, 'playlist_name': data['playlist_name'], 'movie_list': data['movie_list']}
        movies.append(new_playlist)
        return new_playlist, 201


class PlaylistByName(Resource):
    def get(self, name):
        """
        Get a playlist by name
        ---
        parameters:
          - name: name
            in: path
            type: string
            required: true
            description: The name of the playlist to search
        responses:
          200:
            description: Found a playlist
          404:
            description: Playlist not found
        """
        for movie in movies:
            if movie['playlist_name'].lower() == name.lower():
                return movie, 200

        return {'message': 'Playlist not found'}, 404
    
# Routes 
api.add_resource(MovieService, '/MovieService')
api.add_resource(PlaylistByName, '/MovieService/<string:playlistname>')

# Run the app
if __name__ == '__main__':
    app.run(debug=True)
    
    