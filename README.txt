Esempio di batch scritto in spring boot che si schedula ciclicamente, eseguendo cioè i Job in maniera programmata.
Nel nostro caso, il batch censisce degli utenti posti all'interno di un db mysql, per ognuno dei quali genera un codice univoco, setta la data di attivazione,
e salva le modifiche sul db. Il processo riparte ogni minuto, nel nostro caso, secondo la sintassi "cron",settata nel file yml del batch.
Per avviare correttamente l'applicazione:
	-1 creare un db corrispondent
	-2 lanciare gli script my sql per generare le tabelle dei metadati di spring batch
	-3 creare la tabella utenti seguendo il model, e inserirne qualcuno settando a null l'attributo "codice", e le varie date di attivazione e disattivazione


 