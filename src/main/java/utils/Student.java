package utils;

public class Student extends Person
{
    private int id;
    private Class sClass;

    public Student(int id, String firstName, String lastName, String gender, Class sClass)
    {
        super(firstName, lastName, gender);
        this.id = id;
        this.sClass = sClass;
    }

    @Override
    public String role()
    {
        return "student";
    }

    public Class getsClass()
    {
        return sClass;
    }
}
