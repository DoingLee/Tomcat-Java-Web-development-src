<mm:definition name="bookstore" screenId="${requestScope.selectedScreen}" screenNum="6">
       <mm:screen id="enter">
                <mm:parameter name="title" value="Bookstore" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/bookstore.jsp" direct="false"/>
        </mm:screen>
        <mm:screen id="catalog">
                <mm:parameter name="title" value="BookCatalog" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/catalog.jsp" direct="false"/>
        </mm:screen>
        <mm:screen id="bookdetails">
                <mm:parameter name="title" value="BookDescription" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/bookdetails.jsp" direct="false"/>
        </mm:screen>
        <mm:screen id="showcart">
                <mm:parameter name="title" value="ShoppingCart" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/showcart.jsp" direct="false"/>
        </mm:screen>
        <mm:screen id="cashier">
                <mm:parameter name="title" value="Cashier" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/cashier.jsp" direct="false"/>
        </mm:screen>
        <mm:screen id="receipt">
                <mm:parameter name="title" value="Receipt" direct="true"/>
                <mm:parameter name="banner" value="/banner.jsp" direct="false"/>
                <mm:parameter name="body" value="/receipt.jsp" direct="false"/>
        </mm:screen>
</mm:definition>
