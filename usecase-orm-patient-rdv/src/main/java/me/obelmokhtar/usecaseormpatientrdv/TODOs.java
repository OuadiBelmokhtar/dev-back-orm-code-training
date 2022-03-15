package me.obelmokhtar.usecaseormpatientrdv;

public class TODOs {

    // TODO: 3/15/22 :  add Medecin et Consultation + mapping association
    // TODO: 3/15/22 : add un exp pr @ManyToMany
    // TODO: 3/14/22 : commencer par utiliser le mode EAGER juste entre deux classes, et voir les logs Hibernate pr bien comprendre le principe
    // TODO: 3/14/22 : tester le principe de objPatient.getRdvs() est-ce que la List des rdvs sera effctivement chargée de la BD suite à l'appel de getList(), ds le cas d'utilisation du mode LAZY
    // TODO: 3/15/22 : Tester, lorsqu'un Patient instancié avec une List remplie par des rdvs Patient p1=new Patient(null, "", lstRdv), est-ce que le contenu de lstRdv sera aussi inséré ds la BD lors de l'appel à patientRepo.save(patient1) ?

}
