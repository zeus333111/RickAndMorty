package com.zeus.domain.interactor

import com.zeus.domain.models.Character
import com.zeus.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseUseCase<String, Flow<Character?>> {

    override suspend fun invoke(parameter: String): Flow<Character?> {
        return characterRepository.getCharacter(parameter)
    }
}
