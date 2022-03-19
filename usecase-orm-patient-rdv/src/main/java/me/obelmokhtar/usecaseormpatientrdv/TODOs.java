package me.obelmokhtar.usecaseormpatientrdv;

public class TODOs {



    // TODO: 3/18/22 : Tester l insertion pr le cas de *____* // add un Medecin à un Hopital,en appliquant le principe suivant charger Medecin, charger Hopital, puis hop1.getMedecins().add(medc1)
    // // l'ajout des medecins ds h1 marche ds le code, mais ds la BD non (l insertion ne se fait pas ds la table MEDECIN_HOPITALS!
    // TODO: 3/18/22 :  Tester l insertion pr le cas de _1_____*_|CA|_*_____1_
    // TODO: 3/17/22 : add mapping héritage // tester l'insertion pr chaque strategie
    // TODO: 3/14/22 : commencer par utiliser le mode EAGER juste entre deux classes, et voir les logs Hibernate pr bien comprendre le principe
    // TODO: 3/14/22 : tester le principe de objPatient.getRdvs() est-ce que la List des rdvs sera effctivement chargée de la BD suite à l'appel de getList(), ds le cas d'utilisation du mode LAZY
    // TODO: 3/15/22 : Tester, lorsqu'un Patient instancié avec une List remplie par des rdvs Patient p1=new Patient(null, "", lstRdv), est-ce que le contenu de lstRdv sera aussi inséré ds la BD lors de l'appel à patientRepo.save(patient1) ?
// TODO #done: 3/15/22 : add Medecin et Consultation + mapping association
    // TODO #done: 3/15/22 : add un exp pr @ManyToMany
}
