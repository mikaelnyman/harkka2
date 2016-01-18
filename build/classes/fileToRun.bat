rmic -v1.2 hojclient.Laitos
start rmiregistry
start java hojclient.Palvelin
java -Djava.security.policy=hojclient/Laitos.policy hojclient.MainWindow