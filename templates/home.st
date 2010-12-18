<h2>Welcome, $user$</h2>

<h3>Enter Your Addresses, With Amount of Times You Visit Each Respective Address Per Year,
    To Find The Distances To Them From Your Origin</h3>

<section>
    <p>Example:</p>

    <blockquote>
        <p><em>Origin: Brookline, MA</em></p>

        <p><em>Boston, MA : 200</br>
               New York, NY : 4</em></p>
    </blockquote>
</section>

<form action="/" method="post">
    <label for="origin">Origin:</>
    <input id="origin" name="origin" value="" style="display: block; margin-bottom: 25px;"/>

    <label for="addresses">Destinations:</>
    <textarea id="addresses" name="addresses" style="display: block; width: 400px; height: 200px"></textarea>

    <input type="submit" value="Submit"/>
</form>