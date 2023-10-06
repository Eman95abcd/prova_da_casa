<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">

<head>
  <title>Ospedale</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.0/css/all.css" />
                <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.0/css/sharp-solid.css" />
                <link rel="stylesheet"
                    href="https://site-assets.fontawesome.com/releases/v6.4.0/css/sharp-regular.css" />
                <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.0/css/sharp-light.css" />

                <link rel="preconnect" href="https://fonts.googleapis.com">
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>

<body>
    <div class="text-center my-4">
      <h1 class="d-inline">OSPEDALE</h1>
      <i class="fa fa-ambulance fa-2x ms-2" aria-hidden="true"></i>
    </div>
    
  <header>
    <!-- place navbar here -->
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Pazienti</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Profile</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="messages-tab" data-bs-toggle="tab" data-bs-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">Messages</button>
      </li>
    </ul>
    
    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab">
          <div class="text-center my-3">
            <h2 class="d-inline">Lista Pazienti</h2>
            <button class="ms-2 rounded-5 bg-success text-bg-success position-relative text-uppercase border-0" style="bottom: 5px;" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">Inserisci</button>
            <div class="offcanvas offcanvas-start" id="demo">
              <div class="offcanvas-header">
                <h1 class="offcanvas-title">Inserisci Paziente</h1>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
              </div>
              <div class="offcanvas-body">
                <form action="/index" method="post" enctype="application/x-www-form-urlencoded">
                  <input type="hidden" value="">
                  <label for="NomeDaInserire">Nome</label>
                  <input type="text" name="NomeDaInserire" id="NomeDaInserire"
                      class="form-control">
                  <br>
                  <input type="hidden" value="">
                  <label for="CognomeDaInserire">Cognome</label>
                  <input type="text" name="CognomeDaInserire" id="CognomeDaInserire"
                      class="form-control">
                  <br>
                  <input type="hidden" value="">
                  <label for="IndirizzoDaInserire">Indirizzo</label>
                  <input type="text" name="IndirizzoDaInserire" id="IndirizzoDaInserire"
                      class="form-control">
                  <br>
                  <input type="hidden" value="">
                  <label for="EmailDaInserire">Email</label>
                  <input type="email" name="EmailDaInserire" id="EmailDaInserire"
                      class="form-control">
                  <br>
                  <input type="hidden" value="">
                  <label for="DataDiNascitaDaInserire">Data di nascita (YYYY-MM-DD)</label>
                  <input type="text" name="DataDiNascitaDaInserire" id="DataDiNascitaDaInserire"
                      class="form-control">
                  <br>
                  <input type="hidden" value="">
                  <label for="TelefonoDaInserire">Telefono</label>
                  <input type="tel" name="TelefonoDaInserire" id="TelefonoDaInserire"
                      class="form-control">
                  <br>
                  <button class="ms-2 rounded-5 bg-success text-bg-success text-uppercase border-0" type="submit">invia</button>
                </form>
              </div>
            </div>
            
          </div>
          <div class="d-flex justify-content-evenly flex-wrap align-items-start">
            <c:forEach var="paziente" items="${pazienti}">
                <div class="d-flex flex-column border border-info border-3 mx-2 p-3 mb-4">
                    <h3>ID: ${paziente.id}</h3>
                    <h3>Nome: ${paziente.nome}</h3>
                    <h3>Cognome: ${paziente.cognome}</h3>
                    <h3>Indirizzo: ${paziente.indirizzo}</h3>
                    <h3>Email: ${paziente.email}</h3>
                    <h3>Data di Nascita: ${paziente.dataDiNascita}</h3>
                    <h3>Telefono: ${paziente.telefono}</h3>
                </div>
            </c:forEach>
          </div>
    
        </div>
      <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab"> profile </div>
      <div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab"> messages </div>
    </div>

  </header>
  <main>

  </main>
  <footer>
    <!-- place footer here -->
  </footer>
  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
    integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
    integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
</body>

</html>