package Generic_Course;

interface Factory<T extends Manageable> {
	T create();
}