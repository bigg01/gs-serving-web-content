package pojo;

import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import io.fabric8.openshift.client.OpenShiftClient;

//https://github.com/fabric8io/kubernetes-client

public class getprojects {

    private static final Logger logger = LoggerFactory.getLogger(getprojects.class);


    public static void projectlist() {

        String master = "https://localhost:8443/";


        Config config = new ConfigBuilder()
                .withMasterUrl(master).
                        withUsername("developer")
                .withPassword("..").build();

        System.out.println(
                ".... Namespace: " + config.getNamespace());


        try (final OpenShiftClient client = new DefaultOpenShiftClient(config)) {
            String ns = "myproject";

            /*
            System.out.println(
                    client.pods().inNamespace(ns).list()


            );
            */

            ProjectList pl = client.projects().list();


            System.out.println("project: " + pl);


            for (Project pr : pl.getItems()) {

                System.out.println(pr.getMetadata());

            }


        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
    }


    public static void podlist() {

        String master = "https://localhost:8443/";


        Config config = new ConfigBuilder()
                .withMasterUrl(master).
                        withUsername("developer")
                .withPassword("..").build();

        System.out.println(
                ".... Namespace: " + config.getNamespace());


        try (final OpenShiftClient client = new DefaultOpenShiftClient(config)) {
            String ns = "myproject";

            /*
            System.out.println(
                    client.pods().inNamespace(ns).list()


            );
            */

            ProjectList pl = client.projects().list();


            System.out.println("project: " + pl);


            for (Project pr : pl.getItems()) {

                System.out.println(pr.getMetadata());

            }

            PodList ps = client.pods().inNamespace(ns).list();
            NodeList node = client.nodes().list();

            Object a = node.getItems().toArray();
            System.out.println(a);
            System.out.println(node.getItems().toArray());

            // System.out.println(ps);

            System.out.println(
                    ".... PODs: ");

            for (Pod p : ps.getItems()) {

                System.out.println("Name: " + p.getMetadata()
                        .getName());
                System.out.println("Name: " + p.getMetadata()
                        .getLabels());

            }

            /*

            System.out.println(client.events());


            System.out.println(
                    ".... Events: ");

            System.out.println(client.events().inNamespace(ns).list());


            ServiceList serviceList = client.services().inNamespace(ns).list();

            System.out.println(serviceList);


            client.services().inNamespace(ns).watch(new Watcher<Service>() {
                @Override
                public void eventReceived(Watcher.Action action, Service resource) {
                    logger.info("{}: {}", action, resource);
                }
            });

            System.out.println(
                    client.namespaces().list()
            );

            System.out.println(
                    client.namespaces().withLabel("this", "works").list()
            );

            System.out.println(
                    client.pods().withLabel("this", "works").list()
            );

            System.out.println(
                    client.pods().inNamespace("test").withLabel("this", "works").list()
            );

            System.out.println(
                    client.pods().inNamespace("test").withName("testing").get()
            );
            )*/
        } catch (KubernetesClientException e) {
            logger.error(e.getMessage(), e);
        }
    }

}



