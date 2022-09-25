export interface IAddress {
  id?: number;
  country?: string | null;
  city?: string | null;
  district?: string | null;
  commune?: string | null;
  coordinate?: string | null;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public country?: string | null,
    public city?: string | null,
    public district?: string | null,
    public commune?: string | null,
    public coordinate?: string | null
  ) {}
}

export function getAddressIdentifier(address: IAddress): number | undefined {
  return address.id;
}
