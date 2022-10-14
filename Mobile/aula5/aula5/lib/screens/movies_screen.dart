import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart';

import '../components/movie_item_component.dart';
import '../model/movie_model.dart';

class MovieScreen extends StatefulWidget {
  const MovieScreen({super.key});

  @override
  State<MovieScreen> createState() => _MovieScreenState();
}

class _MovieScreenState extends State<MovieScreen> {
  var moviesList = <Movie>[];

  @override
  void initState() {
    super.initState();
    fetchMovies();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: ListView.separated(
          itemCount: moviesList.length,
          separatorBuilder: (_, __) => const SizedBox(height: 8,),
          itemBuilder: (_, index) {
            var movie = moviesList[index];
            return MovieItemComponent(movie: movie);
          }),
    );
  }

  void fetchMovies() async {
    try {
      final uri = Uri.parse('https://demo7206081.mockable.io/movies');
      final response = await Client().get(uri);

      final responseJson = jsonDecode(response.body);

      moviesList = responseJson['results']
          .map<Movie>((jsonMovie) => Movie(jsonMovie['original_title'],
              jsonMovie['overview'], jsonMovie['poster_path']))
          .toList();

      setState(() {});
    } catch (_) {}
  }
}


