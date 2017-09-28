package zhangzhx.samples.maveninvoker;

import java.io.File;
import java.util.Collections;
import java.util.Properties;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class App {

	public static void main(String[] args) throws MavenInvocationException {
        String mavenHome = "/usr/local/Cellar/maven/3.3.9";
        String path = "/Users/zhaoxiz/Workspace/MavenProjects";
        
        InvocationRequest request = new DefaultInvocationRequest();
        request.setShellEnvironmentInherited(false);
        request.setBaseDirectory(new File(path));
        
        request.setGoals(Collections.singletonList("archetype:generate"));
        Properties properties = new Properties();
        properties.put("interactiveMode", "false");
        properties.put("archetypeGroupId", "org.apache.maven.archetypes");
        properties.put("archetypeArtifactId", "maven-archetype-quickstart");
        properties.put("archetypeVersion", "1.1");
        properties.put("groupId", "zhangzhx.samples");
        properties.put("artifactId", "quickstart");
        properties.put("version", "1.0");
        request.setProperties(properties);
        
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenHome));
        invoker.execute(request);
    }
}