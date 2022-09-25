import { IUser } from 'app/entities/user/user.model';

export interface IImage {
  id?: number;
  image?: string | null;
  user_image?: IUser | null;
}

export class Image implements IImage {
  constructor(public id?: number, public image?: string | null, public user_image?: IUser | null) {}
}

export function getImageIdentifier(image: IImage): number | undefined {
  return image.id;
}
