<?xml version="1.0" standalone="no" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
    <xsl:output method="xml" indent="yes" standalone="no" doctype-public="-//W3C//DTD SVG 1.1//EN" doctype-system="http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd" media-type="image/svg" />
    <xsl:template match="/">
        <svg width="2300" height="800">
            <xsl:apply-templates />
        </svg>
    </xsl:template>
    <xsl:template match="/carShowrom">
        <xsl:call-template name="showTitle" />
        <xsl:call-template name="showCars" />
        <xsl:apply-templates select="summarize" />
        <xsl:call-template name="showPicture" />
        <xsl:call-template name="script"/>
    </xsl:template>
    
    <xsl:template name="showTitle">
        <rect x="600" y="1050" height="100" width="100" onclick="alert('WELCOME')"/>
        <text  onclick="alert('WELCOME')" x="0" y="0" font-family="Verdana" font-size="45">
            Car ShowRoom
            <animateMotion path="M 0 800 L 700 800 L 0 800" dur="20s" repeatCount="indefinite" />
        </text>
    </xsl:template>
    
    <xsl:template name="showCars">
        <g font-size="11">
            <rect x="15" y="3" width="1100" height="20" fill="#f1f8e9" />
            <text y="15" x="0" text-align="center">
                <tspan x="30">
                    <xsl:text>
                        Brand
                    </xsl:text>
                </tspan>
                <tspan x="200">
                    <xsl:text>Model</xsl:text>
                </tspan>
                <tspan x="430">
                    <xsl:text>Type</xsl:text>
                </tspan>
                <tspan x="690">
                    <xsl:text>Production</xsl:text>
                </tspan>
                <tspan x="890">
                    <xsl:text>Condition</xsl:text>
                </tspan>
                <tspan x="1010">
                    <xsl:text>Price</xsl:text>
                </tspan>
            </text>
            <xsl:for-each select="/carShowrom/cars/car">
                <xsl:if test="position() mod 2 = 0">
                    <rect x="15" y="{18*position()+3}" width="1100" height="20" fill="#99ccff" />
                </xsl:if>
                <xsl:if test="position() mod 2 = 1">
                    <rect x="15" y="{18*position()+3}" width="1100" height="20" fill="#ccffff" />
                </xsl:if>
                <text id="{@id}" y="{18*position()+15}" x="0" width="200" text-align="center">
                    <tspan x="30">
                        <xsl:value-of select="brand/name" />
                    </tspan>
                    <tspan x="200">
                        <xsl:value-of select="model" />
                    </tspan>
                    <tspan x="430">
                        <xsl:value-of select="type" />
                    </tspan>
                    <tspan x="690">
                        <xsl:value-of select="production" />
                    </tspan>
                    <tspan x="890">
                        <xsl:value-of select="condition" />
                    </tspan>
                    <tspan x="1010">
                        <xsl:value-of select="price" />
                        <xsl:text></xsl:text>
                        <xsl:value-of select="price/@currency" />
                    </tspan>
                </text>
            </xsl:for-each>
        </g>
    </xsl:template>
    <xsl:template match="summarize">
        <xsl:call-template name="showScale" />
        <xsl:for-each select="conditionCarsAmount/*">
            <text x="15" y="{500+position()*15+10}">
                <xsl:value-of select="substring(name(.),0)" />
            </text>
            <rect id="{name(.)}" x="120" y="{500+position()*15}" height="13" width="{. * 40}">
                <xsl:choose>
                    <xsl:when test="substring(name(.),0) = 'new'">
                        <xsl:attribute name="fill">
                            #AA00FF
                        </xsl:attribute>
                    </xsl:when>
                    <xsl:when test="substring(name(.),0) = 'used'">
                        <xsl:attribute name="fill">
                            #647687
                        </xsl:attribute>
                    </xsl:when>
                </xsl:choose>
                <animate id="anim{(.)}" attributeName="width" from="0" to="{. * 40}" dur="{(.) * 0.5}" begin="click" />
            </rect>
        </xsl:for-each>
    </xsl:template>
    <xsl:template name="showScale">
        <rect x="5" y="450" width="1100" height="160" fill="#f1f8e9" />
        <text x="{76+40*1}" y="475">0</text>
        <text x="{76+40*2}" y="475">1</text>
        <text x="{76+40*3}" y="475">2</text>
        <text x="{76+40*4}" y="475">3</text>
        <text x="{76+40*5}" y="475">4</text>
        <text x="{76+40*6}" y="475">5</text>
        <text x="{76+40*7}" y="475">6</text>
        <text x="{76+40*8}" y="475">7</text>
        <text x="{76+40*9}" y="475">8</text>
        <text x="{76+40*10}" y="475">9</text>
        <text x="{76+40*11}" y="475">10</text>
        <text x="{76+40*12}" y="475">11</text>
        <text x="{76+40*13}" y="475">12</text>
        <text x="{76+40*14}" y="475">13</text>
        <text x="{76+40*15}" y="475">14</text>
        <text x="{76+40*16}" y="475">15</text>
        <text x="{76+40*17}" y="475">16</text>
        <text x="{76+40*18}" y="475">17</text>
        <text x="{76+40*19}" y="475">18</text>
        <text x="{76+40*20}" y="475">19</text>
        <text x="{76+40*21}" y="475">20</text>
        <line x1="{80+40*1}" x2="{80+40*1}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*2}" x2="{80+40*2}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*3}" x2="{80+40*3}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*4}" x2="{80+40*4}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*5}" x2="{80+40*5}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*6}" x2="{80+40*6}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*7}" x2="{80+40*7}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*8}" x2="{80+40*8}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*9}" x2="{80+40*9}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*10}" x2="{80+40*10}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*11}" x2="{80+40*11}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*12}" x2="{80+40*12}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*13}" x2="{80+40*13}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*14}" x2="{80+40*14}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*15}" x2="{80+40*15}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*16}" x2="{80+40*16}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*17}" x2="{80+40*17}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*18}" x2="{80+40*18}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*19}" x2="{80+40*19}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*20}" x2="{80+40*20}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
        <line x1="{80+40*21}" x2="{80+40*21}" y1="500" y2="580" stroke="black" stroke-dasharray="5" />
    </xsl:template>
    <xsl:template name="showPicture">
        <image id="carButton" x="500" y="630" xlink:href="car.png" height="100" width="100" />
    </xsl:template> 
    
    <xsl:template name="script">
        <script type="text/javascript">
            document.getElementById("carButton").onclick = function()
            {
                var anims = document.querySelectorAll('[id^="anim"]');
                for (i = 0; i&lt;anims.length; i++)
                {
                    anims[i].beginElement();
                }
            }
        </script>
    </xsl:template>
  
</xsl:stylesheet>