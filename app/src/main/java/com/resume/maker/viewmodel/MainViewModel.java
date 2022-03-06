package com.resume.maker.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.resume.maker.models.EducationModel;
import com.resume.maker.models.ExperienceModel;
import com.resume.maker.models.PersonalDetailsModel;
import com.resume.maker.models.ProjectModel;
import com.resume.maker.repository.Repository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private final Repository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(application);
        repository.login();
        if(FirebaseAuth.getInstance().getCurrentUser() != null) {
            Log.d("__here", "id: " +  FirebaseAuth.getInstance().getCurrentUser().getUid());
        }
    }

    public void addResumeWithPersonalDetails(PersonalDetailsModel personalDetailsModel) {
        repository.addResumeWithPersonalDetails(personalDetailsModel);
    }

    public void addExperience(String id, ArrayList<ExperienceModel> modelArrayList) {
        repository.addExperience(id, modelArrayList);
    }

    public void addProject(String id, ArrayList<ProjectModel> modelArrayList) {
        repository.addProject(id, modelArrayList);
    }
    public void addEducation(String id, ArrayList<EducationModel> educationModels) {
        repository.addEducation(id, educationModels);
    }

    public void addSecondaryDetails(String id, ArrayList<String> langList, ArrayList<String> skillList) {
        repository.addSecondaryDetails(id, langList, skillList);
    }

    public void uploadImage(String id, Uri uri) {
        repository.uploadImage(id, uri);
    }

    public MutableLiveData<FirebaseUser> login() {
        return repository.login();
    }

}
