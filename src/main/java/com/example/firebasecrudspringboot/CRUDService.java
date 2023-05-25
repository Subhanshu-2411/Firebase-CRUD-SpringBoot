package com.example.firebasecrudspringboot;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {
    public String create(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore fireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = fireStore.collection("user").document(crud.getName()).set(crud);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public CRUD get(String documentId) throws ExecutionException, InterruptedException {
        Firestore fireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = fireStore.collection("user").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        return documentSnapshot.exists() ? documentSnapshot.toObject(CRUD.class): null;

    }

    public String update(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore fireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = fireStore.collection("user").document(crud.getName()).set(crud);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String delete(String documentId) {
        Firestore fireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = fireStore.collection("user").document(documentId).delete();
        return "Removed Successfully";
    }
}
