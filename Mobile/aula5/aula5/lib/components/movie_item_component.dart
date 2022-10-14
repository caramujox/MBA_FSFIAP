import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

import '../model/movie_model.dart';

class MovieItemComponent extends StatelessWidget {
  const MovieItemComponent({
    Key? key,
    required this.movie,
  }) : super(key: key);

  final Movie movie;

  @override
  Widget build(BuildContext context) {
    return Material(
      elevation: 4,
      borderRadius: BorderRadius.circular(16),
      child: Row(children: [
        Expanded(
            child: ClipRRect(
              child: Image.network(movie.image),
              borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(16),
                  bottomLeft: Radius.circular(16)),
            ),
            flex: 1),
        Expanded(
          flex: 3,
          child: Column(children: [
            Text(
              movie.title,
              style:
                  GoogleFonts.lato(fontSize: 16, fontWeight: FontWeight.bold),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text(
                movie.description,
                maxLines: 5,
                overflow: TextOverflow.ellipsis,
                style: GoogleFonts.lato(fontSize: 12, fontWeight: FontWeight.normal),
              ),
            ),
          ]),
        )
      ]),
    );
  }
}
