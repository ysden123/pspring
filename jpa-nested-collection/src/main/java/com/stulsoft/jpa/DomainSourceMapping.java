package com.stulsoft.jpa;

import javax.persistence.*;

@Entity(name = "DomainSourceMapping")
@Table(name = "domainSourceMappings")
public class DomainSourceMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="sourceFileId")
    private SourceFile sourceFile;

    @ManyToOne
    @JoinColumn(name="sourceLibraryId")
    private SourceLibrary sourceLibrary;

    protected DomainSourceMapping(){

    }

    public DomainSourceMapping(SourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }

    public DomainSourceMapping(SourceFile sourceFile, SourceLibrary sourceLibrary) {
        this.sourceFile = sourceFile;
        this.sourceLibrary = sourceLibrary;
    }


    public SourceFile getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(SourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }

    public SourceLibrary getSourceLibrary() {
        return sourceLibrary;
    }

    public void setSourceLibrary(SourceLibrary sourceLibrary) {
        this.sourceLibrary = sourceLibrary;
    }

    @Override
    public String toString() {
        return "DomainSourceMapping{" +
                "id=" + id +
                ", sourceFile=" + sourceFile +
                ", sourceLibrary=" + sourceLibrary +
                '}';
    }
}
