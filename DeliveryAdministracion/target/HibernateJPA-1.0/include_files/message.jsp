<!-- Mensajes -->
        <c:if test="${errorVal!=null}">
            <div class="alert w-100 m-0 bg-white p-0 pt-4 rounded-0">
                <div <c:if test="${errorVal==true}">class=" px-3 alert-danger mb-0 row mx-5 rounded border"</c:if> <c:if test="${errorVal==false}">class=" px-3 alert-success mb-0 row mx-5 rounded border"</c:if> style="transform: rotate(0);" role="alert">
                    <button type="button" class="close stretched-link py-3 align-middle" data-dismiss="alert" aria-label="Close">
                        &times;
                    </button>
                    <div class="align-middle py-3 ml-3 pl-3 border-left">
                        <p class="mb-0 h6 d-inline-block">${msj}</p> <!-- <-------- Variable con mensjae -->
                    </div>
                </div>
            </div>
        </c:if>