<div class="d-flex flex-column flex-wrap">
    <h2 class="d-inline ms-5 text-center my-3" >Lista Letti</h2>
    <c:forEach var="letto" items="${letti}">
        <div class="d-flex flex-column border border-info border-3 mx-2 p-3 mb-4">
            <h3>Codice Letto: ${letto.codice}</h3>
            <h3>Unita' Operativa: ${letto.unitaOperativa}</h3>
            <h3>ID Paziente: $</h3>
            <h3>Data Prenotazione: $</h3>
        </div>
    </c:forEach>