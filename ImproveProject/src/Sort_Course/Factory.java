package Sort_Course;

interface Factory<T extends Manageable> {
	T create();
}