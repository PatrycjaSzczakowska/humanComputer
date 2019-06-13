<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" version="1.0" encoding="UTF-8"/>

  <xsl:key name="conditions" match="condition" use="." />

  <xsl:template match="/">
    <carShowrom>
      <name>CAR SHOWROOM</name>
      <xsl:apply-templates />
      <brands_alphabetically>
        <xsl:for-each select="carShowroom/brands/brand">
          <xsl:sort select="name" data-type="text" order="ascending" />
          <brand>
            <name>
              <xsl:value-of select="name" />
            </name>
            <headquarters>
              <xsl:value-of select="headquarters" />
            </headquarters>
          </brand>
        </xsl:for-each>
      </brands_alphabetically>
      <summarize>
        <currentDate>09.05.2019</currentDate>
        <authorsNumber>
          <xsl:value-of select="count(/carShowroom/metadata/authors/author)" />
        </authorsNumber>
        <brandsNumber>
          <xsl:value-of select="count(/carShowroom/brands/brand)" />
        </brandsNumber>
        <carsNumber>
          <xsl:value-of select="count(/carShowroom/cars/car)" />
        </carsNumber>
        <highestPrice>
          <xsl:variable name="highestPrice">
            <xsl:for-each select="(/carShowroom/cars/car/price)">
              <xsl:sort data-type="number" order="descending" />
              <xsl:if test="position()=1">
                <xsl:value-of select="." />
              </xsl:if>
            </xsl:for-each>
          </xsl:variable>
          <xsl:value-of select="format-number($highestPrice,'0.00')" />
        </highestPrice>
        <lowestPrice>
          <xsl:variable name="lowestPrice">
            <xsl:for-each select="(/carShowroom/cars/car/price)">
              <xsl:sort data-type="number" order="ascending" />
              <xsl:if test="position()=1">
                <xsl:value-of select="." />
              </xsl:if>
            </xsl:for-each>
          </xsl:variable>
          <xsl:value-of select="format-number($lowestPrice,'0.00')" />
        </lowestPrice>
        <allCarsPrice>
          <xsl:attribute name="currency">
            <xsl:text>USD</xsl:text>
          </xsl:attribute>
          <xsl:variable name="allCarsPrice">
            <xsl:value-of select="sum(/carShowroom/cars/car/price)" />
          </xsl:variable>
          <xsl:value-of select="format-number($allCarsPrice,'0')" />
        </allCarsPrice>
        <conditionCarsAmount>
          <xsl:for-each select="/carShowroom/cars/car/condition[generate-id() = generate-id(key('conditions',.)[1])]">
            <xsl:variable name="condition">
              <xsl:value-of select="." />
            </xsl:variable>
            <xsl:element name="{$condition}">
              <xsl:value-of select="count(/carShowroom/cars/car/condition[.=$condition])" />
            </xsl:element>
          </xsl:for-each>
        </conditionCarsAmount>
      </summarize>
    </carShowrom>
  </xsl:template>

  <xsl:template match="/carShowroom">
    <xsl:apply-templates />
  </xsl:template>

  <xsl:template match="/carShowroom/brands">
    <brandsPart>BRANDS</brandsPart>
    <brands>
      <xsl:for-each select="brand">
        <brand>
          <xsl:copy-of select="@id" />
          <xsl:copy-of select="name" />
          <xsl:copy-of select="chairman" />
          <xsl:copy-of select="country" />
        </brand>
      </xsl:for-each>
    </brands>
  </xsl:template>

  <xsl:template match="/carShowroom/cars">
    <carsPart>CARS</carsPart>
    <cars>
      <xsl:apply-templates />
    </cars>
  </xsl:template>

  <xsl:template match="car">
    <car>
      <xsl:variable name="brand">
        <xsl:value-of select="@brandId" />
      </xsl:variable>
      <xsl:apply-templates select="/carShowroom/brands/brand [@id = $brand]" />
      <xsl:copy-of select="model" />
      <xsl:copy-of select="type" />
      <xsl:copy-of select="production" />
      <xsl:copy-of select="condition" />
      <xsl:copy-of select="price" />
    </car>
  </xsl:template>

  <xsl:template match="carShowroom/brands/brand">
    <brand>
      <xsl:copy-of select="name" />
    </brand>
  </xsl:template>

  <xsl:template match="/carShowroom/metadata">
    <metadata>
      <xsl:apply-templates select="authors" />
      <xsl:copy-of select="modificationDate" />
    </metadata>
  </xsl:template>

  <xsl:template match="authors">
    <authors>
      <xsl:for-each select="author">
        <author>
          <xsl:copy-of select="@index" />
        </author>
      </xsl:for-each>
    </authors>
  </xsl:template>
  
</xsl:stylesheet>