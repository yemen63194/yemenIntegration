package com.example.carecareforeldres.Service;

import com.example.carecareforeldres.Entity.Homeless;
import com.example.carecareforeldres.Entity.Shelter;
import com.example.carecareforeldres.Repository.HomelessRepository;
import com.example.carecareforeldres.Repository.ShelterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class HomelessService implements IHomelessService{
    HomelessRepository homelessRepository ;
    ShelterRepository shelterRepository;
    @Override
    public List<Homeless> retrieveAllHomeless() {
        return homelessRepository.findAll();
    }

    @Override
    public Homeless addHomeless(Homeless s) {
        return homelessRepository.save(s);
    }

    @Override
    public Homeless updateHomeless(Homeless s) {
        return homelessRepository.save(s);
    }

    @Override
    public Homeless retrieveHomeless(Long idHomeless) {
        return homelessRepository.findById(idHomeless).get();
    }

    @Override
    public void removeHomeless(Long idHomeless) {
        homelessRepository.deleteById(idHomeless);
    }


    @Override
    public Homeless addHomelessAndUpdateCapacity(Homeless homeless, Long idSheletr) {
        Shelter shelter = shelterRepository.findById(idSheletr).get();
        shelter.setNbrPlaceDisponible(shelter.getCapaciteShelter());
        Long currentAvailablePlaces = shelter.getNbrPlaceDisponible();

        if (currentAvailablePlaces > 0) {
            shelter.setNbrPlaceDisponible(currentAvailablePlaces - 1);
            if (currentAvailablePlaces - 1 == 0) {
                shelter.setStatut("Saturé");
            }
            homeless.setShelter(shelter);
            homelessRepository.save(homeless);
        }
        return homeless;
    }





    // recherhceHomelessAvecSaLocation(String location):

    //  recherhcelessByAgeGreaterThan(Integer age):
    //  recherhcelessBySituationMedicale(String situation):


    //public double calculatePercentageOfHomelessWithMedicalNeeds();
    //public service ajoutServiceSpecifiqueSelonHomlessNeeds();
    //public addHomlessAndAssingToShelterWithCapacityCondititon() ;
    // public nbrehomlessDansChaqueSheletrParTypeServie ;
}

