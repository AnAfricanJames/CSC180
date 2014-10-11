
public interface Event
{
		/**
		 * prints a message to the screen
		 * indicating what the user should do.
		 */
		void show();
		/**
		 * takes in the user's next request
		 *  and decides what state the user is now in.
		 * @return
		 */
		Event next();
}

