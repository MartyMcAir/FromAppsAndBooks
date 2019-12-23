package GenericReflectionQuery_2309;

import GenericReflectionQuery_2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
// https://javarush.ru/tasks/com.javarush.task.task23.task2309#discussion
// solved mined in first chance
// but Intrested Example Sample..
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    /////////////////////////
    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }

    public List<Location> getLocations() {
        // Unchecked assignment
//        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor() {
        // right way
        AbstractDbSelectExecutor<Location> abs = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
//        return new ArrayList<Location>();
        return abs.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }

}
