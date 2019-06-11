<?xml version="1.0" encoding="UTF-8" ?>
<!-- was: no XML declaration present -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" indent="yes" />
    <xsl:template match="/">
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>CAR SHOWROOM</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Data: 15.05.2019</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select="concat(substring('MODEL				                ', 1, 25), '|   ')" />
        <xsl:value-of select="concat(substring('BRAND					                ', 1, 25), '|   ')" />
        <xsl:value-of select="concat(substring('TYPE					                   ', 1, 25), '|   ')" />
        <xsl:value-of select="concat(substring('PRODUCTION					              ', 1, 25), '|   ')" />
        <xsl:value-of select="concat(substring('CONDITION					            ', 1, 25), '|   ')" />
        <xsl:value-of select="concat(substring('PRICE					                ', 1, 25), '|   ')" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:for-each select="/carShowrom/cars/car">
            <xsl:variable name="MODEL" select="model" />
            <xsl:variable name="BRAND" select="brand/name" />
            <xsl:variable name="TYPE" select="type" />
            <xsl:variable name="PRODUCTION" select="production" />
            <xsl:variable name="CONDITION" select="condition" />
            <xsl:variable name="PRICE" select="price" />
            <xsl:value-of select="concat(substring(concat($MODEL,'                      '), 1, 25),'|   ')" />
            <xsl:value-of select="concat(substring(concat($BRAND,'                      '), 1, 25),'|   ')" />
            <xsl:value-of select="concat(substring(concat($TYPE,'                      '), 1, 25),'|   ')" />
            <xsl:value-of select="concat(substring(concat($PRODUCTION,'                      '), 1, 25),'|   ')" />
            <xsl:value-of select="concat(substring(concat($CONDITION,'                      '), 1, 25),'|   ')" />
            <xsl:value-of select="concat(substring(concat($PRICE,'                      '), 1, 25),'|   ')" />
            <xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>MARKI ALFABETYCZNIE </xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:value-of select="concat(substring(concat('Marka','                                               '), 1, 50),'|   ')" />
        <xsl:value-of select="concat(substring(concat('Siedziba','                                               '), 1, 50),'|   ')" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:for-each select="/carShowrom/brands_alphabetically/brand">
            <xsl:variable name="NAME" select="name" />
            <xsl:variable name="HEADQUARTERS" select="headquarters" />
            <xsl:value-of select="concat(substring(concat($NAME,'                                               '), 1, 50),'|   ')" />
            <xsl:value-of select="concat(substring(concat($HEADQUARTERS,'                                               '), 1, 50),'|   ')" />
            <xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text> PODSUMOWANIE </xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Data podsumowania: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/currentDate" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Łączna liczba autorów: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/authorsNumber" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Łączna liczba aut: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/carsNumber" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Łączna liczba marek: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/brandsNumber" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Najwyższa cena: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/highestPrice" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Najniższa cena: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/lowestPrice" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Suma cen: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/allCarsPrice" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Ilość używanych aut: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/conditionCarsAmount/used" />
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>Ilość nowych aut: </xsl:text>
        <xsl:value-of select="/carShowrom/summarize/conditionCarsAmount/new" />
        <xsl:text>&#xa;</xsl:text>
    </xsl:template>
    <xsl:template match="authors">
        <xsl:for-each select="author">
            <xsl:value-of select="name" />
            <xsl:text></xsl:text>
            <xsl:value-of select="surname" />
            <xsl:text> (</xsl:text>
            <xsl:value-of select="index_number" />
            <xsl:text>)&#xa;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>