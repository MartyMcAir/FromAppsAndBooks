package z_OOP_BiG_Pack.SecurityProxyChecker_3709.connectors;

import z_OOP_BiG_Pack.SecurityProxyChecker_3709.security.SecurityChecker;
import z_OOP_BiG_Pack.SecurityProxyChecker_3709.security.SecurityCheckerImpl;

// производить проверку безопасности перед подключением.
// В случае, если проверка не пройдена, соединение не должно быть установлено.

// Для клиента (в данном случае класс SolutionV2) использование SecurityProxyConnector ничем не должно отличаться
// от использования класса SimpleConnector.
public class SecurityProxyConnector implements Connector {
    private String resourceString;
    private SecurityChecker securityChecker = new SecurityCheckerImpl();
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        this.resourceString = resourceString;
        this.simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}
