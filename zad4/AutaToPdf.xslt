<?xml version="1.0" encoding="utf-16" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" encoding="UTF-16" indent="yes" />
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="CarShowroom" page-height="700px" page-width="11in">
                    <fo:region-body region-name="only_region" margin="1in" background-color="#fff3f3" />
                </fo:simple-page-master>
                <fo:simple-page-master master-name="Summarize" page-height="320px" page-width="10in">
                    <fo:region-body region-name="only_region" margin="1in" background-color="#fff3f3" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="CarShowroom">
                <fo:flow flow-name="only_region">
                    <fo:block text-align="center" font-weight="bold" color="#810000" font-size="20" padding-top="10" padding-bottom="10">
                    List of cars
                    </fo:block>
                    <fo:table border="solid 1pt #810000" table-layout="fixed" width="100%" font-size="10">
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell width="150px">
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000" padding-top="6">Brands</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000" padding-top="6">Model</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000" padding-top="6">Type</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000">Prodution</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000">Condition</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="center" font-weight="bold" font-size="12" color="#810000" padding-top="6">Price</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="/carShowrom/cars/car">
                                <fo:table-row border-width="0.2px" border-style="solid" color="#810000" height="40">
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align-last="center" color="#ff5b5b">
                                            <xsl:value-of select="brand/name" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align="center" color="#ff5b5b">
                                            <xsl:value-of select="model" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align="center" color="#ff5b5b">
                                            <xsl:value-of select="type" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align="center" color="#ff5b5b">
                                            <xsl:value-of select="production" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align="center" color="#ff5b5b">
                                            <xsl:value-of select="condition" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding-top="5">
                                        <fo:block text-align="center" color="#ff5b5b">
                                            <xsl:value-of select="price" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="Summarize">
                <fo:flow flow-name="only_region">
                    <fo:block text-align="center" font-weight="bold" font-size="14" color="#810000" padding-top="7" padding-bottom="7">
                        Summarize
                    </fo:block>
                    <fo:list-block>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Ilosc autorow: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/authorsNumber" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Data podsumowania: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/currentDate" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Ilosc aut: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/carsNumber" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Ilosc brandow: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/brandsNumber" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Najwyzsza cena: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/highestPrice" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Najnizsza cena: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/lowestPrice" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Cena wszystkich aut: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/allCarsPrice" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Ilosc uzywanych aut: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/conditionCarsAmount/new" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <fo:list-item-label>
                                <fo:block color="#ff5b5b">Ilosc nowych aut: </fo:block>
                            </fo:list-item-label>
                            <fo:list-item-body>
                                <fo:block margin-left="20em" color="#ff5b5b">
                                    <xsl:value-of select="/carShowrom/summarize/conditionCarsAmount/used" />
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                    </fo:list-block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>