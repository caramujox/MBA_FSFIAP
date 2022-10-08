import 'package:flutter/material.dart';
import 'package:quiz_app/components/quiz_button.dart';
import 'package:quiz_app/model/question_model.dart';
import 'package:quiz_app/screens/end_game.dart';

class QuizScreen extends StatefulWidget {
  const QuizScreen({super.key, required this.title});
  static const String id = 'quizScreen';
  final String title;

  @override
  State<QuizScreen> createState() => _QuizScreenState();
}

class _QuizScreenState extends State<QuizScreen> {
  List<QuestionModel> questions = [];
  var questionIndex = 0;
  var score = 0;

  @override
  void initState() {
    super.initState();
    questions = loadQuestions();
  }

  List<QuestionModel> loadQuestions() {
    return [
      QuestionModel(
          question: "Qual é o meu nome?",
          answer: 0,
          options: ['Caio', 'Pedro', 'Bruno', 'Gabriel']),
      QuestionModel(
          question: "Qual é o nome do meu gato?",
          answer: 2,
          options: ['Floky', 'Luke', 'Jorel', 'Peter Parker']),
    ];
  }

  onOptionPressed(int selectedOption) {
    final currentQuestion = questions[questionIndex];

    if (selectedOption == currentQuestion.answer) {
      score++;
    }
    if (questionIndex >= questions.length-1) {
      Navigator.pushNamed(context, EndGameScreen.id,
          arguments: EndGameArgs(correctAnswers: score));
    } else {
      setState(() {
        questionIndex++;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final currentQuestion = questions[questionIndex];
    return Scaffold(
        body: SafeArea(
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text('Pontos:'),
            SizedBox(
              height: 40,
            ),
            Text(score.toString()),
            SizedBox(
              height: 40,
            ),
            Text(currentQuestion.question),
            SizedBox(
              height: 32,
            ),
            ListView.separated(
                shrinkWrap: true,
                itemBuilder: (context, index) {
                  return QuestionButton(
                    text: currentQuestion.options[index],
                    onPressed: () {
                      print(index);
                      onOptionPressed(index);
                    },
                  );
                },
                separatorBuilder: (context, index) => const SizedBox(
                      height: 8,
                    ),
                itemCount: currentQuestion.options.length),
          ],
        ),
      ),
    ));
  }
}
