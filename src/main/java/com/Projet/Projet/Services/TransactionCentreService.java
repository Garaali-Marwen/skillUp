package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.TransactionCentre;

import java.util.List;

public interface TransactionCentreService {

    TransactionCentre addTransaction(TransactionCentre transactionCentre);
    List<TransactionCentre> getAllTransactions();
    TransactionCentre getTransactionById(Long transactionId);
    TransactionCentre updateTransaction(TransactionCentre transactionCentre);
    void deleteTransaction(Long transactionId);
    TransactionCentre addTransactionToCentre(Long centreId, Long transactionId);
    TransactionCentre addTransactionToAbonnement(Long abonnementId, Long transactionId);
}
