package utils;

public class Teacher extends Person
{
    private int id;

    public Teacher(int id, String firstName, String lastName, String gender)
    {
        super(firstName, lastName, gender);
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String role()
    {
        return "teacher";
    }
}
