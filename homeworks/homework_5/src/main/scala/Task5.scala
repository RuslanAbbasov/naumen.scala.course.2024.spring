import scala.util.{Failure, Success, Try}

/*
  Задание №5
  Задание аналогично предыдущему задания, но теперь мы уходим от использования стандартного Either.
  Нужно:
  1) Доделать реализацию MyEither (нужны аналоги Right и Left)
  2) Написать для MyEither инстанс MonadError
  3) Написать функции apply, error, possibleError
 */
object Task5 extends App {
  import Task4.MonadError

  sealed trait MyEither[+E, +A] {
    def isError: Boolean
  }

  
  final case class Right[+E, +A](value: A) extends MyEither[E, A] {
    override def isError: Boolean = false
  }

  final case class Left[+E, +A](value: E) extends MyEither[E, A] {
    override def isError: Boolean = true
  }
  
  object MyEither {
    def apply[A](value: A): MyEither[Nothing, A] = Right(value)
    def error[E, A](error: E): MyEither[E, A] = Left(error)
    def possibleError[A](f: => A): MyEither[Throwable, A] = Try(f) match {
      case Success(value) => Right(value)
      case Failure(exception) => Left(exception)
    }

    implicit def myEitherMonad[E]: MonadError[MyEither, E] = new MonadError[MyEither, E] {
      override def pure[A](value: A): MyEither[E, A] = Right(value)

      override def flatMap[A, B](value: MyEither[E, A])(func: A => MyEither[E, B]): MyEither[E, B] = value match {
        case Right(value) => func(value)
        case Left(error) => Left(error)
      }

    override def handleError[A](value: MyEither[E, A])(func: E => A): MyEither[E, A] = value match {
        case Right(value) => Right(value)
        case Left(error) => Right(func(error))
      }

      override def raiseError[A](fa: MyEither[E, A])(error: => E): MyEither[E, A] = Left(error)
    }
  }

  object MyEitherSyntax {
    implicit class MyEitherOps[E, A](val either: MyEither[E, A]) {
      def flatMap[B](f: A => MyEither[E, B]): MyEither[E, B] =
        MyEither.myEitherMonad[E].flatMap(either)(f)

      def map[B](f: A => B): MyEither[E, B] = MyEither.myEitherMonad.map(either)(f)

      def handleError(f: E => A): MyEither[E, A] =
        MyEither.myEitherMonad.handleError(either)(f)
    }
  }
}
