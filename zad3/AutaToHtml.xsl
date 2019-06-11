<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xhtml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" />
    <xsl:template match="/">
        <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"/>
                <title>
                    <xsl:value-of select="carShowrom/name" />
                </title>
            </head>
            <body>
                <div class="pure-g">
                    <div class="pure-u-1-5"></div>
                    <div class="pure-u-3-5">
                        <h2>Authors</h2>
                        <xsl:for-each select="carShowrom/metadata/authors/author">
                            <p>
                                <xsl:value-of select="@index" />
                            </p>
                        </xsl:for-each>
                        <h2>
                            <xsl:value-of select="carShowrom/brandsPart" />
                        </h2>
                        <table class="pure-table">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Country</th>
                                <th>Chairman</th>
                            </tr>
                            <xsl:for-each select="carShowrom/brands/brand">
                                <tr>
                                    <td>
                                        <xsl:value-of select="@id" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="name" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="country" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="chairman" />
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table>
                        <h2>
                            <xsl:value-of select="carShowrom/carsPart" />
                        </h2>
                        <table class="pure-table">
                            <tr>
                                <th>Brand</th>
                                <th>Model</th>
                                <th>Type</th>
                                <th>Production</th>
                                <th>Price</th>
                            </tr>
                            <xsl:for-each select="carShowrom/cars/car">
                                <tr>
                                    <td>
                                        <xsl:value-of select="brand/name" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="model" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="type" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="production" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="price" />
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table>
                        <h4>Summary</h4>
                        <p>
                            Brands number:
                            <xsl:value-of select="carShowrom/summarize/brandsNumber" />
                        </p>
                        <p>
                            Cars number:
                            <xsl:value-of select="carShowrom/summarize/carsNumber"  />
                        </p>
                        <p>
                            Highest price:
                            <xsl:value-of select="carShowrom/summarize/highestPrice" />
                        </p>
                        <p>
                            Lowest price:
                            <xsl:value-of select="carShowrom/summarize/lowestPrice" />
                        </p>
                        <p>
                            All cars price:
                            <xsl:value-of select="carShowrom/summarize/allCarsPrice" />
                        </p>
                        <p>
                            Number of used cars:
                            <xsl:value-of select="carShowrom/summarize/conditionCarsAmount/used" />
                        </p>
                        <p>
                            Number of new cars:
                            <xsl:value-of select="carShowrom/summarize/conditionCarsAmount/new" />
                        </p>
                    </div>
                    <div class="pure-u-1-5"></div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>