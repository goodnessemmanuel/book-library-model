package utils;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>
{

    @Override
    public int compare(final Person o1, final Person o2) {
        //return Integer.compare(o1.getFirstName(), o2.getFirstName());
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
