<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>

    <xsl:template match="/">
        <html>
            <body>
                <h2><xsl:value-of select="view/header/title"/></h2>
                <form>
                    <xsl:attribute name="name">
                        <xsl:value-of select="view/body/form/name"/>
                    </xsl:attribute>
                    <xsl:attribute name="action">
                        <xsl:value-of select="view/body/form/action"/>
                    </xsl:attribute>
                    <xsl:attribute name="method">
                        <xsl:value-of select="view/body/form/method"/>
                    </xsl:attribute>
                    <xsl:for-each select="view/body/form/textView">
                        <label>
                            <xsl:attribute name="for">
                                <xsl:value-of select="label"/>
                            </xsl:attribute>
                            <xsl:value-of select="label"/>
                        </label>
                        <br/>
                        <input type="text">
                            <xsl:attribute name="name">
                                <xsl:value-of select="name"/>
                            </xsl:attribute>
                            <xsl:attribute name="value">
                                <xsl:value-of select="value"/>
                            </xsl:attribute>
                            <xsl:attribute name="id">
                                <xsl:value-of select="label"/>
                            </xsl:attribute>
                            <br/>
                        </input>
                    </xsl:for-each>
                    <input type="submit">
                        <xsl:attribute name="value">
                            <xsl:value-of select="view/body/form/buttonView/label"/>
                        </xsl:attribute>
                    </input>
                </form>
                <a href="/">return</a>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>