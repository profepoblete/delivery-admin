        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
        -->
        <link href="files/linkeds/bootstrap-icons.css" rel="stylesheet" type="text/css"/>
        <link href="files/linkeds/bootstrap4.5.2.css" rel="stylesheet" type="text/css"/>
        <link href="files/linkeds/bootstrap4.5.2.min.css" rel="stylesheet" type="text/css"/>
        <link href="files/linkeds/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/vnd.microsoft.icon" href="assets/favicon.ico">
        <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico">
        <link rel="icon" href="assets/favicon.ico" sizes="32x32" />
        <link rel="icon" href="assets/favicon.ico" sizes="192x192" />
        <link rel="apple-touch-icon" href="assets/favicon.ico" />
        <meta name="msapplication-TileImage" content="assets/favicon.ico" />
        <!-- CSS ADICIONAL -->
        <!-- COLORES: [Azul:#00284f/#012c56]  [Negro:1a1a1a]    -->
        <style type="text/css">
            .dropdown-menu-right{
                left: auto !important;
            }
            .login-header{
                border-style: solid;
                border-width: 0 0 0 10px;
                border-color: #00284f;
            }
            /*INICIO: CAJAS P�GINA PRINCIPAL*/
            .home-box{
                max-width: 800px;
                background-size:800px 400px;
                background-position:0px -50px;
                overflow:hidden;
                transition: all .4s ease-in-out;
            }
            .home-box:hover{
                background-size:830px 420px;
                background-position:-15px -60px;
            }
            .div-home-box{
                transition: all .4s ease-in-out;
                background: rgba(26, 26, 26, 0.6);
            }
            .home-box:hover .div-home-box{
                background: rgba(26, 26, 26, 0.2);
            }
            .icon-in-box-l{
                position: absolute;
                left:0px;
                top:20px;
                height: 60px;
                width: 20%;
                padding-top: 10px;
                padding-right: 20px;
                background-color: rgba(227, 163, 0, .6);
                transition: all .4s;
            }
            .home-box:hover .icon-in-box-l{
                top:16px;
                background-color: rgba(227, 163, 0, 1);
                width: 22%;
                box-shadow: -12px 4px 0px 0px rgba(0, 0, 0, .4);
            }
            .icon-in-box-r{
                position: absolute;
                left:80%;
                top:20px;
                height: 60px;
                width: 20%;
                padding-top: 10px;
                padding-left: 20px;
                background-color: rgba(227, 163, 0, .6);
                transition: all .4s;
            }
            .home-box:hover .icon-in-box-r{
                top:16px;
                background-color: rgba(227, 163, 0, 1);
                width: 22%;
                left:78%;
                box-shadow: 12px 4px 0px 0px rgba(0, 0, 0, .4);
            }
            .home-box div div a{
                color: rgba(255, 255, 255, .8);
                border: 2px solid rgba(255, 255, 255, .8);
                text-decoration: none;
                transition: all .4s ease-in-out;
                border-radius: 25px;
                padding: 9px 30px 9px 45px;
                font-size: 1rem;
                background: rgba(0, 0, 0, .3);
            }
            .home-box div div:hover a{
                background: rgba(0, 0, 0, .7);
                border-color: rgba(255, 255, 255, 1);
                box-shadow: 0px 0px 3px 1px rgb(255 255 255 / 50%);
                color: rgba(255, 255, 255, 1);
            }
            .home-box div div h1 {
                color: rgba(255, 255, 255, 1);
            }
            .home-box:hover div div h1{
                transition: all .3s ease-in-out;
                text-shadow:1px -1px 4px rgba(150, 150, 150, .5);

                    
                /*transform: scale(1.07);*/
            }
            /*FIN: CAJAS P�GINA PRINCIPAL*/
            
            #navbarSupportedContent a{
                color: white;
                opacity: 0.75;
            }
            #navbarSupportedContent a:hover{
                opacity: 1;
            }
            
            .dropdown-toggle::after{
                margin-left: 0px;
            }
            .dropdown-menu{
                padding: 0px 6px 6px 6px;
                border-width: 0;
                margin-top: 0;
                border-radius: 0;
                box-shadow: 1px 1px 0px 1px rgb(0 0 0 / 40%);
            }
            
            .dropdown-menu a{
                opacity: 0.75;
            }
            
            
            /*INICIO COLORES AZUL o NEGRO |||||||||||||||*/
            .big-home-box{
                /*background-color: #1A1A1A;*/
                background-color: white;
                
            }
            #navbarSupportedContent .show{
                background-color: rgba(45, 45, 45, 1);
                opacity: 1;
            }
            
            #navbarSupportedContent .show a{
                opacity: 1;
            }

            #navbarSupportedContent .fade{
                background-color: rgba(0, 0, 0, 0.15);
            }
            
            .dropdown-menu a:hover{
                background-color: rgba(0, 0, 0, 1);
                opacity: 1 !important;
                /*box-shadow: 0px 0px 2px 2px rgb(255 255 255 / 10%);*/
            }
            
            .img-card{
                background-color: #1a1a1a;
                border-radius: 4px;
            }
            
            main .container-fluid{
                background-color: #1a1a1a;
            }
            
            main .card{
                border-color: #1a1a1a;
            }
            
            nav{
                background-color: #1a1a1a;
            }
            
            body{
                background-color: #1a1a1a;
            }
            
            footer .container-fluid{
                background-color: #1a1a1a;
            }
            /*FIN COLORES AZUL o NEGRO ||||||||||||||||||*/
            
            .error {
                color: red;
                margin-bottom: 0;
            }
            
            .card-body .card-link{
                color: rgba(0, 0, 0, .7);
                transition: all .1s ease-in-out;
            }
            
            .card-body .card-link:hover{
                color: rgba(0, 0, 0, 1);
                /*text-shadow:1px 1px 1px rgba(0, 0, 0, .15);*/
            }
            
            .custom-file-input ~ .custom-file-label::after {
                content: "Elegir";
            }

            .action-buttons span a, .action-buttons span button{
                color: rgba(0, 136, 255, .9) !important;
                outline: none;
            }
            
            .action-buttons span a:hover, .action-buttons span button:hover{
                color: rgba(0, 87, 237, 1) !important;
            }


            
            .btn-success {
                color: #fff;
                background: rgba(109, 212, 0, .75);
                border: rgba(97, 187, 1, 1);
            }
            .btn-success:hover {
                background: rgba(109, 212, 0, 1);
                border: rgba(97, 187, 1, 1);
                box-shadow: 0px 0px 3px 1px rgb(97 187 1 / 50%);
                opacity: 1;
                color: #fff;
            }
            
            .btn-addelem {
                margin-top: 10px;
                color: rgba(255, 255, 255, 1);
                background: rgba(0, 123, 255, .8);
                border: rgba(0, 123, 255, .8);
                border-style: solid;
                border-width: 1px;
                padding: 0.2rem 0.7rem 0.2rem 0.375rem;
                font-size: 0.95rem;
                border-radius: 4px;
                text-transform: uppercase;
                transition: all .2s ease-in-out;
                text-align: center;
            }
            .btn-addelem:hover {
                border-color: rgba(0, 123, 255, 1);
                box-shadow: 0px 0px 3px 1px rgb(0 123 255 / 50%);
                opacity: 1;
                color: rgba(255, 255, 255, 1);
                background: rgba(0, 123, 255, 1);
                text-decoration: none;
            }
            
            .btn-danger {
                color: #fff;
                background: rgba(220, 53, 69, .8);
                border: rgba(220, 53, 69, 1);
            }
            .btn-danger:hover {
                background: rgba(220, 53, 69, 1);
                border: rgba(220, 53, 69, 1);
                box-shadow: 0px 0px 3px 1px rgb(220 53 69 / 50%);
                opacity: 1;
                color: #fff;
            }
            
            .btn-primary {
                color: #fff;
                background: rgba(0, 123, 255, .8);
                border: rgba(0, 123, 255, 1);
            }
            .btn-primary:hover {
                background: rgba(0, 123, 255, 1);
                border: rgba(0, 123, 255, 1);
                box-shadow: 0px 0px 3px 1px rgb(0 123 255 / 50%);
                opacity: 1;
                color: #fff;
            }
            
            
            .btn {
                padding: 0.6rem 1.75rem;
                border-radius: 100px;
                text-transform: uppercase;
                font-size: 1rem;
                border-width: 2px !important;
                font-weight: bold;
                text-decoration: none;
                font-style: normal;
            }
            .btn:hover {
                transition: all .15s ease-in-out;
                text-decoration: none;
            }
            .modal-footer .btn {
                padding: 0.4rem 1rem;
                border-radius: 100px;
                text-transform: uppercase;
                font-size: 0.75rem;
                border-width: 2px !important;
                font-weight: bold;
                text-decoration: none;
                font-style: normal;
            }
            
            .navigation-links{
                color: rgba(0, 123, 255, .7);
                opacity: .9;
                font-size: 1.05rem;
            }
            .navigation-links a, .navigation-links button{
                color: rgba(0, 123, 255, .7);
                text-decoration: none;
                transition: all .15s ease-in-out;
                background-color: transparent;
                border-width: 0;
                padding: 0;
                outline: none;
            }

            .navigation-links a:hover, .navigation-links button:hover{
                color: rgba(0, 123, 255, 1);
                text-decoration: none;
            }
            
            
            .dataTables_info{
                padding-top: 2px !important;
            }
            
            .dataTables_paginate{
                padding-top: 5px !important;
            }
            
            
            .btn-clear-filters {
                margin: 0px;
                color: rgba(0, 0, 0, .65);
                background-color: transparent;
                border-width: 0px;
                padding: 1px 0 1px 0;
                font-size: 1rem;
                text-transform: uppercase;
                transition: all .4s;
                border-radius: 5px;
                text-align: center;
                outline: none;
                text-decoration: underline;
            }
            .btn-clear-filters:hover {
                color: rgba(0, 0, 0, 1);
                outline: none;
            }
            
            
            footer a{
                opacity: .8;
                transition: all .15s ease-in-out;
                text-transform: uppercase;
                font-size: 0.9rem;
            }
            footer a:hover{
                opacity: 1;
                /*transform: scale(1.05);*/
            }
            footer ul li a{
                display: inline-block !important;
                width: auto;
            }
            footer a i:hover{
                /*font-size:20px;*/
            }
            /*ERROR CSS*/
            #error-container a{
                color: rgba(255, 255, 255, .8);
                border: 2px solid rgba(255, 255, 255, .8);
                text-decoration: none;
                transition: all .4s ease-in-out;
                border-radius: 25px;
                padding: 9px 45px 9px 30px;
                font-size: 1rem;
                background: rgba(0, 0, 0, .6);
            }
            #error-container a:hover{
                background: rgba(0, 0, 0, .9);
                border-color: rgba(255, 255, 255, 1);
                box-shadow: 0px 0px 3px 1px rgb(255 255 255 / 50%);
                color: rgba(255, 255, 255, 1);
            }
            
        </style>